
# Weather Forecasting Application


The app delivers detailed weather forecasts, providing users with valuable insights and necessary information.


## Screenshots

![](https://github.com/ALLETttttt/WeatherForecasting-App/blob/main/Снимок%20экрана%202023-08-06%20в%2022.21.36.png?raw=true)


## Acknowledgements

 - [Awesome link to learn](https://developer.android.com/courses?gclid=Cj0KCQjwib2mBhDWARIsAPZUn_m374aP5PhALjZlBoCNIysJVHLcKPC0qXoC9xaXpwhBKsSTh_eyce0aAsCXEALw_wcB&gclsrc=aw.ds)
 - [Youtube channel too more practice](https://www.youtube.com/@NecoRuChannel)



## FAQ

#### What is the Weather Forecasting App?

The application that provides precise and reliable predictions based on up-to-date data and advanced algorithms.

#### What is the purpose of this project and for who?

It helps users plan their activities, make informed decisions, and stay prepared for changing weather conditions. For those who depend on weather information for work, travel, or safety reasons, this app becomes an indispensable tool.
## Features

- Alert Dialog for setting up the city
- Live previews
- Fullscreen mode
- Cross platform
- Synchronize with real-time weather
- Max/Min temperatures of each hours


## Usage/Examples
Main part

```javascript
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WeatherForecastingApp7Theme {

                val navController = rememberNavController()

                NavHost(navController = navController, startDestination = "splash_screen") {

                    composable("splash_screen") {
                        SplashScreen(navController = navController)
                    }

                    composable("welcome_screen") {
                        WelcomeScreen(navController = navController)
                    }

                    composable("main_screen") {
                        Start(this@MainActivity)
                    }
                }
            }
        }
    }
}

```


## Appendix

- For user interface used Jetpack Compose
- Datas coming from this link [Weather API](https://www.weatherapi.com)
- For realizing the project used: library Volley to fetch API, States to track the data`s condition.
- Realised Splash Screen
- Coroutines for animation
## Optimizations
Used
``
navControoler()
``
for optimizing memory and navigate the pages, it supports to be more comfortable and because of that used only 1 activity. 
