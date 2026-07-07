#🎬 Watchlist - Your Ultimate Cinema Companion

**Watchlist** is a modern, premium Android application designed for cinephiles and anime lovers. It allows you to track, rate, and discover movies and series with a beautiful, immersive interface.

---

## ✨ Features

- **Midnight Cinema Theme:** A high-end dark interface featuring deep navy backgrounds and movie-gold accents for a premium feel.
- **TMDB Integration:** Powered by [The Movie Database (TMDB)](https://www.themoviedb.org/), the app automatically fetches high-quality posters for your movies and anime.
- **Smart Tracking:** Easily toggle between "Watching" and "Completed" states.
- **Personal Ratings:** Rate your favorite entries using a 5-star system.
- **Local Persistence:** Your list is stored locally on your device using **Room Database**, ensuring your data is always accessible offline.
- **Seamless Navigation:** Smooth transitions between your personal list and the adding screen.

---

## 🛠️ Tech Stack

- **Language:** [Kotlin](https://kotlinlang.org/)
- **UI:** [Jetpack Compose](https://developer.android.com/jetpack/compose) with Material 3
- **Architecture:** MVVM (Model-View-ViewModel)
- **Database:** [Room](https://developer.android.com/training/data-storage/room)
- **Networking:** [Retrofit](https://square.github.io/retrofit/) + [GSON](https://github.com/google/gson)
- **Image Loading:** [Coil](https://coil-kt.github.io/coil/)
- **Navigation:** [Compose Navigation](https://developer.android.com/jetpack/compose/navigation)

---

## 🚀 Getting Started

### Prerequisites
- Android Studio Ladybug (or newer)
- Android SDK 35
- A [TMDB API Key](https://www.themoviedb.org/documentation/api)

### Installation
1. Clone the repository:
2. Open the project in Android Studio.
3. Navigate to com.example.watchlist.data.network.RetrofitInstance.
4. Replace API_KEY with your personal TMDB API key:
5. Open the project in **Android Studio**.
6. Navigate to `com.example.watchlist.data.network.RetrofitInstance`.
7. Replace `API_KEY` with your personal TMDB API key:
kotlin const val API_KEY = "YOUR_TMDB_API_KEY_HERE"
5. Sync Gradle and run the app on an emulator or physical device.

---

## 📸 UI Preview

| Home Screen | Add New Entry |
| :---: | :---: |
| ![Home](https://via.placeholder.com/300x600?text=Midnight+Cinema+Home) | ![Add](https://via.placeholder.com/300x600?text=Premium+Add+Screen) |

---

## 📜 License

Distributed under the MIT License. See `LICENSE` for more information.

---

**Developed with ❤️ by YourName**
