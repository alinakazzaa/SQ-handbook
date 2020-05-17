package classes;

import java.util.ArrayList;

public class Answer {

	private Question question;
	private int score;
	
	public Answer(Question question, int score) {
		super();
		this.question = question;
		this.score = score;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
	
	
}

