# Modern E-Learning Android Application

A clean, natively compiled e-learning user interface built using Android Jetpack Compose, Kotlin, and state navigation handlers. 

## 🛠️ Features Implemented
* **Home Screen:** Dynamic category row with course item counters, an interactive search input component, and custom multi-tone vector gradients for course cards.
* **Course Details:** Deep links course object items down into actionable lessons data mapping strings.
* **Lesson Player Screen:** Reconstructs custom video media configurations featuring active timeline scrubbers, playback status highlights, and lesson item states (Free vs Locked).

---

## 🚀 AI-First Development Workflow

This application was structured and developed using an AI-assisted design paradigm in partnership with **Gemini**. The collaborative process prioritized transforming static wireframe UI mockups into active declarative layouts.

### 📋 Sample Prompts Sent to AI
1. *"Based on this design specification mockup for the Lesson Player UI, what is the cleanest approach to structure the declarative layouts in Jetpack Compose to handle the media scrubber timeline and track the state of the active playlist element?"*
2. *"How should I optimize the horizontal scrolling LazyRow for the category chips so that item text labels stack responsively without stretching the parent Card container bounds?"*
3. *"I am encountering compilation errors during the APK assembly phase regarding Unresolved reference 'LearningAppTheme' and Composable context constraints inside ExampleUnitTest.kt. What is the root cause of these test harness failures during code generation, and how do I safely refactor the unit test file to restore the build pipeline?"*

### 🧠 AI Strengths & Corrections Handle
* **What the AI Got Right:** Flawlessly read spatial relationships directly from raw screenshot images. It translated layout grids seamlessly, matched visual hex code color tokens, and generated the core linear background gradients beautifully.
* **What it Got Wrong & How It Was Fixed:** During a rapid UI code refactor, the AI hallucinated a parameter name (`architecturalWeight`) that does not exist in the Jetpack Compose framework, and applied sizing constants using standard `dp` units instead of scale-independent text pixels (`sp`). We identified the breaking syntax compilation points, switched the typo declaration to `fontWeight`, swapped the measurement types back to `.sp`, and achieved a 100% clean build pipeline.

---

## 📦 Submission Deliverables

* **Repository Link:** [github.com/sonyvishwakarma/LearningApp]
* **Compiled Debug APK Path:** Located within the local compilation artifacts folder hierarchy at:  
  `app/build/outputs/apk/debug/app-debug.apk`
