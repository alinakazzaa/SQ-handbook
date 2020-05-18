package main;

import java.util.ArrayList;

import classes.Question;
import classes.Survey;
import classes.SurveyResponse;
import classes.Answer;
import java.util.concurrent.ThreadLocalRandom;

public class SurveyMain {
	
	private ArrayList<Survey> surveys = new ArrayList<Survey>();
	
	public SurveyMain() {
		createTestSurvey();
	}
	
	public void main(String[] args) {
		new SurveyMain();
	}
	
	// add survey to list
	public void addSurvey(String name) {
		Survey newSurvey = new Survey((surveys.size() + 1), name);
		surveys.add(newSurvey);
	}
	
	// add a question to a survey
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
	
	
	// get all surveys
	public ArrayList<Survey> getAllSurveys() {
		return surveys;
	}
	
	// get survey by name
	public Survey getSurveyByName(String name) {

		for(Survey survey: this.surveys) {
			if(survey.getName().equals(name)) {
				return survey;
			}
		}
		
		return null;	
	}
	
	// add response to survey
	public void addResponseToSurvey(int surveyId) {
		int index = surveyId - 1;
		Survey survey = surveys.get(index);
		SurveyResponse response = new SurveyResponse((survey.getResponses().size() + 1));
		survey.addResponse(response);		
	}
	
	// add answer to response
	public void addAnswerToResponse(int surveyId, int responseId, Question question, int score) {
		Answer answer = new Answer(question, score);
		Survey survey = surveys.get(surveyId - 1);
		SurveyResponse response = survey.getResponses().get(responseId - 1);
		response.addAnswer(answer);
		survey.getResponses().set((responseId - 1), response);
	}
	
	// get all responses of survey
	public ArrayList<SurveyResponse> getAllSurveyResponses(int surveyId) {
		return surveys.get(surveyId -1).getResponses();
	}
	
	public Survey createTestSurvey() {
		String testSurvey = "Test Survey";
		addSurvey(testSurvey);
		Survey survey = getSurveyByName(testSurvey);
		String qstn = "Test Question";
		
		for(int i = 1; i < 6; i++) {
			addQuestionToSurvey(survey.getId(), (qstn.concat(Integer.toString(i))));
		}
		
		
		for(int r = 0; r < 5; r++) {
			
			addResponseToSurvey(survey.getId());
			
			// testing function
			System.out.println("added response " + survey.getResponses().get(r).getId());
			
			for(int q = 0; q < survey.getQuestions().size(); q++) {
				// generate random score between 1 and 5
				int randomScore = ThreadLocalRandom.current().nextInt(1, 5);
				SurveyResponse currentResp = survey.getResponses().get(r);
				Question currentQstn = survey.getQuestions().get(q);
				
				System.out.println("current response: " + currentResp.getId());
				System.out.println("current question: " + currentQstn.getText());

				addAnswerToResponse(survey.getId(), currentResp.getId(), currentQstn, randomScore);
				System.out.println("added answer " + randomScore + " to question " + currentQstn.getId());
			}
		}
		
		return survey;
	}
	
	public double getSurveyAverage(Survey survey) {
		int average = 0;
		int totalScore = 0;
		int totalAnswers = 0;
		
		ArrayList<SurveyResponse> responses = survey.getResponses();
		
		for(SurveyResponse response: responses) {
			ArrayList<Answer> answers = response.getAnswers();
			totalAnswers = totalAnswers + answers.size();
			
			for(Answer answer: answers) {
				totalScore = totalScore + answer.getScore();
			}	
		}
		
		average = totalScore / totalAnswers;
		
		return average;
	}
}
