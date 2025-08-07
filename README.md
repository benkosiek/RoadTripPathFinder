# 🚀 Java Projects: Canvas Responder + Road Trip Route Planner

This repository contains two fully functional Java projects:

1. 🧠 **Canvas OpenAI Responder** – Automates replies to Canvas discussion posts using OpenAI GPT.
2. 🗺️ **RoadTripFinal** – Graph-based route planner that calculates cheapest paths and trip costs between cities.

---

## 🧠 Project 1: Canvas + OpenAI Discussion Responder

### 📚 Overview
Automatically reads the latest uploaded PDF and discussion post from Canvas, summarizes it using OpenAI's API, and posts a reply in Canvas.

### ⚙️ Features
- Canvas LMS API integration
- PDF text extraction using Apache PDFBox
- Prompt generation and OpenAI response via `gpt-4o`
- Posts response back into Canvas discussions

### 🛠 Technologies
- Java 11+
- OpenAI API (`gpt-4o`)
- Apache PDFBox
- Canvas REST API
- `org.json`

### 📁 Key Files
- `Main.java`: Main controller
- `Canvas.java`: Handles PDF & Canvas API logic
- `ChatGPT.java`: Handles OpenAI communication

### 🔐 API Setup
Set these environment variables:
```bash
export OPENAI_API_KEY=your_openai_key
export CANVAS_API_KEY=your_canvas_key
