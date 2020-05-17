package main;

import java.util.ArrayList;

import classes.Question;
import classes.Survey;

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
		
		
	
}
