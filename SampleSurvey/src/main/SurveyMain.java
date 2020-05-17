package main;

import java.util.ArrayList;

import classes.Question;
import classes.Survey;
import classes.SurveyResponse;
import classes.Answer;

public class SurveyMain {
	
	private ArrayList<Survey> surveys = new ArrayList<Survey>();
	
	public void addSurvey(String name) {
		Survey newSurvey = new Survey((surveys.size() + 1), name);
		surveys.add(newSurvey);
	}
	
	public void addQuestionToSurvey(int surveyId, String question) {
		int index = surveyId - 1;
		Survey survey = surveys.get(index);
		ArrayList<Question> questions = survey.getQuestions();
		
		if(questions.size() <= 10) {
			Question newQuestion = new Question((questions.size() + 1), question);
			survey.addQuestion(newQuestion);
			
			surveys.set(index, survey);
		} 
		else {
			// error checking here to say there are already 10 questions added to the survey
		}
		
	}
	
	public ArrayList<Survey> getAllSurveys() {
		return surveys;
	}
	
	public Survey getSurveyByName(String name) {

		for(Survey survey: this.surveys) {
			if(survey.getName().equals(name)) {
				return survey;
			}
		}
		
		return null;	
	}
	
	public void addResponseToSurvey(int surveyId) {
		int index = surveyId - 1;
		Survey survey = surveys.get(index);
		SurveyResponse response = new SurveyResponse((survey.getResponses().size() + 1));
		survey.addResponse(response);		
	}
	
	public void addAnswerToResponse(int surveyId, int responseId, Question question, int score) {
		Answer answer = new Answer(question, score);
		Survey survey = surveys.get(surveyId - 1);
		SurveyResponse response = survey.getResponses().get(responseId - 1);
		response.addAnswer(answer);
		survey.getResponses().set((responseId - 1), response);
	}
}
