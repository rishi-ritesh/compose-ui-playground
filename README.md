<!-- Banner -->
<p align="center">
  <picture>
    <source srcset="assets/banner.svg" type="image/svg+xml">
    <img src="assets/banner.png" alt="Compose UI Playground banner" width="900" />
  </picture>
</p>

# 🌟 Compose UI Playground
A curated Jetpack Compose portfolio showcasing interactive demos: **animations**, **custom layouts**, **gestures**, and **design system tokens**.  
This project grows in tiny, iterative steps — perfect for learning and for showcasing modern Compose UI engineering.

---

## 🎨 Features (Current)

### 🧭 Core Architecture
- **Typed Navigation** using a sealed `PlaygroundScreen`
- **MVVM + StateFlow** for predictable UI state
- **Material 3 Design System** with dynamic color + custom tokens
- **Reusable UI components** (DemoCard, SectionHeader, TopBar, Spacing, Typography)

### 🎥 UI Demos

### ✨ Animated Button
Morphing width, state transitions, and color animations.

<p align="center">
  <img src="assets/gifs/animated_button.gif" width="280"/>
</p>


<img src="assets/gifs/animated_button.gif" width="260"/>

#### 📚 Complex LazyColumn
Sectioned lists with headers, cards, and preview support.

<img src="assets/gifs/complex_lazy.gif" width="260"/>

> **Note:** GIFs above are placeholders — final demo recordings will be added later.

---

## 🛠️ Tech Stack

- **Jetpack Compose** (Material 3)
- **Navigation Compose**
- **Kotlin StateFlow / MVVM**
- **Dynamic color theming** (Android 12+)
- **Well-structured, scalable package layout**
- **Previews** for fast iterative UI development

---

1️⃣ Clone the project
git clone https://github.com/rishi-ritesh/compose-ui-playground.git

2️⃣ Open in Android Studio
Use Android Studio Giraffe or newer.

3️⃣ Run
Launch the app module on an emulator or device.

📂 Project Structure

composeplayground/
├── app/
│    └── playground/
│         ├── demos/
│         │    ├── animations/
│         │    ├── layouts/
│         │    ├── gestures/
│         │    ├── components/
│         ├── navigation/
│         ├── ui/
├── ui/theme/
└── assets/
├── gifs/
├── banner.svg
└── banner.png


🧭 Roadmap
Animation Demos

AnimatedVisibility basics

State transitions

Decay + Spring physics animations

Motion path animations

Layout Demos

Staggered grid (custom layout)

Flow / wrap layout

SubcomposeLayout samples

Gesture Demos

Drag & drop reordering

Swipe actions

Pinch-to-zoom + pan

Components Showcase

Advanced TextField

Custom TopAppBars

Card variants

Chip components

Tooling

In-app code preview

Screenshot generator

Demo comparison tools

🤝 Contributions

As this is a personal playground project, contributions are optional — but feel free to fork it or open ideas for new demos.

📌 Status

🚧 Work in progress — new demos are added step-by-step to ensure the project remains clean, scalable, and portfolio-ready.