package com.example.composefragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.core.os.bundleOf
import androidx.fragment.compose.AndroidFragment
import androidx.fragment.compose.rememberFragmentState

class HomeFragment : Fragment() {

    private lateinit var username: String
    var navigateToProfileScreen: (() -> Unit)? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        username = requireArguments().getString(ARG_USERNAME) ?: error("No username")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<TextView>(R.id.tv).text = "Hello $username"

        view.findViewById<Button>(R.id.button).setOnClickListener { navigateToProfileScreen?.invoke() }
    }

    companion object {
        const val ARG_USERNAME = "username"
    }

}

@Composable
fun HomeScreen(
    username: String,
    navigateToProfileScreen:() -> Unit
) {
    AndroidFragment<HomeFragment>(
        modifier = Modifier.statusBarsPadding(),
        arguments = bundleOf(HomeFragment.ARG_USERNAME to username),
        onUpdate = { fragment ->
            fragment.navigateToProfileScreen = navigateToProfileScreen
        }
    )
}












