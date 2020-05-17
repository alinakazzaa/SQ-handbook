package classes;

import java.util.ArrayList;

public class Survey {
	
	private int id;
	private String name;
	private ArrayList<Question> questions = new ArrayList<Question>();
	private ArrayList<SurveyResponse> responses = new ArrayList<SurveyResponse>();
	
	
	public ArrayList<SurveyResponse> getResponses() {
		return responses;
	}


	public void addResponse(SurveyResponse response) {
		this.responses.add(response);
	}


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
