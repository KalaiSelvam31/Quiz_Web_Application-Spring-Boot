const quizId = localStorage.getItem("selectedQuizId") ;

console.log("Loading Quiz ID:", quizId);

window.onload = async function () {
  try {
    const response = await fetch(`http://localhost:8080/quiz/get/${quizId}`);
    const questions = await response.json();
    const container = document.getElementById("quiz-container");

    // Store questions globally for later use during submission
    window.quizQuestions = questions;

    questions.forEach((q, index) => {
      const questionDiv = document.createElement("div");
      questionDiv.classList.add("question");

      // Add question text safely
      const questionText = document.createElement("p");
      questionText.textContent = `${index + 1}. ${q.questionText}`;
      questionDiv.appendChild(questionText);

      // Add options using text nodes to prevent HTML rendering
      ["option_A", "option_B", "option_C", "option_D"].forEach(optionKey => {
        const optionLabel = document.createElement("label");
        const radio = document.createElement("input");
        radio.type = "radio";
        radio.name = `q${index}`;
        radio.value = q[optionKey];

        optionLabel.appendChild(radio);
        optionLabel.appendChild(document.createTextNode(" " + q[optionKey]));
        questionDiv.appendChild(optionLabel);
        questionDiv.appendChild(document.createElement("br"));
      });

      container.appendChild(questionDiv);
    });

  } catch (error) {
    console.error("Error loading quiz:", error);
    alert("Failed to load quiz. Check your backend or network connection.");
  }
};

async function submitQuiz() {
  try {
    const answers = [];

    window.quizQuestions.forEach((q, index) => {
      const selected = document.querySelector(`input[name="q${index}"]:checked`);
      const answer = selected ? selected.value : null;

      answers.push({
        id: q.id,
        correct_answer: answer
      });
    });

    const response = await fetch(`http://localhost:8080/quiz/submit/${quizId}`, {
      method: "POST",
      headers: {
        "Content-Type": "application/json"
      },
      body: JSON.stringify(answers)
    });

    const score = await response.json();
    alert(`🎉 You scored: ${score} / ${window.quizQuestions.length}`);
  } catch (error) {
    console.error("Error submitting quiz:", error);
    alert("Failed to submit quiz. Please try again.");
  }
}
