package io.codelabs.blog.view

import android.os.Bundle
import android.os.Handler
import android.util.Patterns
import android.view.View
import android.view.inputmethod.EditorInfo
import androidx.core.widget.addTextChangedListener
import androidx.databinding.DataBindingUtil
import androidx.transition.TransitionManager
import io.codelabs.blog.R
import io.codelabs.blog.core.BlogRootActivity
import io.codelabs.blog.databinding.ActivityAuthBinding
import io.codelabs.blog.model.User
import io.codelabs.blog.util.intentTo
import io.codelabs.blog.util.toggleView
import io.codelabs.sdk.util.showConfirmationToast
import kotlinx.coroutines.launch

class AuthActivity : BlogRootActivity() {
    private lateinit var binding: ActivityAuthBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_auth)

        binding.close.setOnClickListener { onBackPressed() }
        binding.loading.visibility = View.GONE

        binding.email.addTextChangedListener { text ->
            binding.login.isEnabled =
                !text.isNullOrEmpty() && !binding.password.text.isNullOrEmpty() && binding.password.text!!.length > 4
        }

        binding.password.addTextChangedListener { text ->
            binding.login.isEnabled =
                !text.isNullOrEmpty() && !binding.email.text.isNullOrEmpty() && Patterns.EMAIL_ADDRESS.matcher(binding.email.text).matches()
        }

        binding.password.setOnEditorActionListener { _, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                binding.login.performClick()
                return@setOnEditorActionListener true
            }
            return@setOnEditorActionListener false
        }

        binding.login.setOnClickListener {
            val email = binding.email.text.toString()
            val password = binding.password.text.toString()

            toggleView(false, binding.email, binding.password)

            TransitionManager.beginDelayedTransition(binding.container)
            binding.content.visibility = View.GONE
            binding.loading.visibility = View.VISIBLE

            //todo: store user data in the database
            Handler().postDelayed({
                ioScope.launch {
                    database.token = email
                    database.key = password

                    dao.createUser(User(password, email))

                    uiScope.launch {
                        showConfirmationToast("", email)
                        intentTo(HomeActivity::class.java, true)
                    }
                }
            }, 3000)
        }
    }
}
