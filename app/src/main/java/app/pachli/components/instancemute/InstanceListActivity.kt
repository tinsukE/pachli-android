package app.pachli.components.instancemute

import android.os.Bundle
import app.pachli.BaseActivity
import app.pachli.R
import app.pachli.components.instancemute.fragment.InstanceListFragment
import app.pachli.databinding.ActivityAccountListBinding
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

class InstanceListActivity : BaseActivity(), HasAndroidInjector {

    @Inject
    lateinit var androidInjector: DispatchingAndroidInjector<Any>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityAccountListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.includedToolbar.toolbar)
        supportActionBar?.apply {
            setTitle(R.string.title_domain_mutes)
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowHomeEnabled(true)
        }

        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container, InstanceListFragment())
            .commit()
    }

    override fun androidInjector() = androidInjector
}
