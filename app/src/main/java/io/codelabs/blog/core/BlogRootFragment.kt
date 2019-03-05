package io.codelabs.blog.core

import android.content.Context
import android.os.Bundle
import android.transition.AutoTransition
import android.transition.ChangeBounds
import androidx.fragment.app.Fragment
import io.codelabs.blog.api.BlogService
import io.codelabs.blog.core.room.BlogAppDao
import io.codelabs.sdk.util.debugLog
import io.codelabs.sdk.util.toast
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf

abstract class BlogRootFragment constructor() : Fragment() {
    private val job = Job()

    val database: UserDatabase by inject { parametersOf(requireActivity().application as BlogApplication) }
    val dao: BlogAppDao by inject { parametersOf(requireActivity().application as BlogApplication) }
    val blogService: BlogService by inject()

    /**
     * Used for background tasks
     */
    val ioScope = CoroutineScope(Dispatchers.IO + job)

    /**
     * Used for foreground tasks
     */
    val uiScope = CoroutineScope(Dispatchers.Main + job)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedElementEnterTransition = ChangeBounds()
        sharedElementReturnTransition = AutoTransition()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        requireActivity().toast(this::class.java.name)
    }

    override fun onDestroy() {
        super.onDestroy()
        job.cancel()
    }

}