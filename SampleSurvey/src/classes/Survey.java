package classes;

import java.util.ArrayList;

public class Survey {
	
	private int id;
	private String name;
	private ArrayList<Question> questions;
	
	
	public Survey(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public ArrayList<Question> getQuestions() {
		return questions;
	}


	public void addQuestion(Question question) {
		this.questions.add(question);
	}
}
