package com.mystackoverflows.plex

import android.os.Bundle
import android.view.Menu
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.navigation.NavigationView
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.drawerlayout.widget.DrawerLayout
import androidx.appcompat.app.AppCompatActivity
import com.mystackoverflows.plex.databinding.ActivityMainBinding
import kotlinx.serialization.json.Json

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.appBarMain.toolbar)

        binding.appBarMain.fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
        val drawerLayout: DrawerLayout = binding.drawerLayout
        val navView: NavigationView = binding.navView
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
//        appBarConfiguration = AppBarConfiguration(setOf(R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow), drawerLayout)
        appBarConfiguration =
            AppBarConfiguration(setOf(R.id.nav_home, R.id.nav_gallery), drawerLayout)
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

        val decoder = Json { ignoreUnknownKeys = true }
        val yes = decoder.decodeFromString<EpisodeSerializable>(
            "{" +
                    "\"grandparentTitle\": \"86 EIGHTY-SIX\"," +
                    "\"parentIndex\": 1," +
                    "\"grandparentThumb\": \"/library/metadata/5838/thumb/1708519451\"," +
                    "\"addedAt\": 1661361362," +
                    "\"grandparentSlug\": \"86-eighty-six\"," +
                    "\"year\": 2021," +
                    "\"thumb\": \"/library/metadata/5856/thumb/1698042144\"," +
                    "\"parentRatingKey\": \"5855\"," +
                    "\"grandparentKey\": \"/library/metadata/5838\"," +
                    "\"ratingKey\": \"5856\"," +
                    "\"type\": \"episode\"," +
                    "\"title\": \"Undertaker\"," +
                    "\"lastViewedAt\": 1664351818," +
                    "\"duration\": 1422180," +
                    "\"grandparentRatingKey\": \"5838\"," +
                    "\"viewCount\": 2," +
                    "\"key\": \"/library/metadata/5856\"," +
                    "\"grandparentGuid\": \"plex://show/5e7362fb4a62f90040e89827\"," +
                    "\"updatedAt\": 1698042144," +
                    "\"summary\": \"The Republic of San Magnolia fights a safe humane war using drones. In reality, however, the drones are piloted by humans called 86s, who are called \\u201cpigs\\u201d and considered less than human.\"," +
                    "\"art\": \"/library/metadata/5838/art/1708519451\"," +
                    "\"audienceRating\": 8," +
                    "\"Media\": [" +
                    "{" +
                    "\"container\": \"mkv\"," +
                    "\"videoProfile\": \"main 10\"," +
                    "\"bitrate\": 1533," +
                    "\"aspectRatio\": 1.78," +
                    "\"audioCodec\": \"aac\"," +
                    "\"videoFrameRate\": \"24p\"," +
                    "\"duration\": 1422180," +
                    "\"audioChannels\": 2," +
                    "\"audioProfile\": \"lc\"," +
                    "\"Part\": [" +
                    "{" +
                    "\"duration\": 1422180," +
                    "\"container\": \"mkv\"," +
                    "\"file\": \"/srv/share/plex_media/Anime/86 Eighty Six/Season 1/[Judas] 86 - S01E01.mkv\"," +
                    "\"audioProfile\": \"lc\"," +
                    "\"size\": 278822465," +
                    "\"videoProfile\": \"main 10\"," +
                    "\"id\": 11213," +
                    "\"key\": \"/library/parts/11213/1661360973/file.mkv\"" +
                    "}" +
                    "]," +
                    "\"width\": 1920," +
                    "\"id\": 8795," +
                    "\"videoResolution\": \"1080\"," +
                    "\"height\": 1080," +
                    "\"videoCodec\": \"hevc\"" +
                    "}" +
                    "]," +
                    "\"Director\": [{ \"tag\": \"Toshimasa Ishii\" }]," +
                    "\"index\": 1," +
                    "\"originallyAvailableAt\": \"2021-04-11\"," +
                    "\"parentTitle\": \"Season 1\"," +
                    "\"parentThumb\": \"/library/metadata/5855/thumb/1681181625\"," +
                    "\"Role\": [" +
                    "{ \"tag\": \"Yuya Murakami\" }," +
                    "{ \"tag\": \"Makoto Sahara\" }," +
                    "{ \"tag\": \"Ayaka Shimizu\" }" +
                    "]," +
                    "\"grandparentTheme\": \"/library/metadata/5838/theme/1708519451\"," +
                    "\"grandparentArt\": \"/library/metadata/5838/art/1708519451\"," +
                    "\"parentKey\": \"/library/metadata/5855\"," +
                    "\"originalTitle\": \"86: Eighty Six\"," +
                    "\"parentGuid\": \"plex://season/602e7951ea35e0002c25594d\"," +
                    "\"guid\": \"plex://episode/5e7362fb4a62f90040e8982b\"," +
                    "\"contentRating\": \"TV-MA\"," +
                    "\"audienceRatingImage\": \"themoviedb://image.rating\"," +
                    "\"Writer\": [{ \"tag\": \"Toshiya Ohno\" }]" +
                    "}"
        )
        println(yes.skipCount);
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }
}