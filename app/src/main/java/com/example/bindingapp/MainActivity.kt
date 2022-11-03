package com.example.bindingapp

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
import android.view.View
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import com.example.bindingapp.databinding.ActivityMainBinding

/** ViewBinding and DataBinding
 * Em fragment, o viewBinding é feito assim:
 *
 * private var _binding: ResultProfileBinding? = null
 * private val binding get() = _binding!!
 *
 * override fun onCreateView(
 *    inflater: LayoutInflater,
 *    container: ViewGroup?,
 *    savedInstanceState: Bundle?
 * ): View? {
 *    _binding = ResultProfileBinding.inflate(inflater, container, false)
 *    val view = binding.root
 *    return view
 * }
 *
 * override fun onDestroyView() {
 *    super.onDestroyView()
 *    _binding = null
 * }
 */

class MainActivity : AppCompatActivity() {
    //viewBinding
    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //viewbinding
        //binding = ActivityMainBinding.inflate(layoutInflater)

        //databinding
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        binding.viewmodel = viewModel
        binding.lifecycleOwner = this
        setupViews()
        //viewBinding
        //setContentView(binding.root)
    }

    private fun setupViews() {
        binding.title.text = "Type your name"

        binding.button.setOnClickListener {
            var name = binding.editText.text.toString()
            binding.editText.text.clear()
            viewModel.updateName(name)
            name = "Welcome, $name"
            binding.title.text = name
        }
    }

}