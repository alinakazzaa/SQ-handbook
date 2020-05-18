package testing;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import classes.Question;
import classes.Survey;
import classes.SurveyResponse;
import classes.Answer;
import main.SurveyMain;
import java.text.DecimalFormat;


class SurveyTest {
	
	private SurveyMain surveyMain = new SurveyMain();
	private ArrayList<Survey>surveys = surveyMain.getAllSurveys();
	private int lBefore, lAfter;
	private String testSurvey = "Test Survey";
	private String testQuestion = "Question 1 Test";
	
	@Test
	void testAddSurvey() {
		
		lBefore = surveys.size();
		surveyMain.addSurvey(testSurvey);
		lAfter = surveys.size();
		
		if(lBefore < lAfter) {
			return;
		} else {
			fail("Fail create new survey survey");
		}
	}
	
	@Test
	void testGetAllSurveys() {

		if(surveyMain.getAllSurveys() != null) {
			return;
		} else {
			fail("Fail get all surveys");
		}
	}
	
	@Test
	void testGetSurveyByName() {
		
		surveyMain.addSurvey(testSurvey);
		Survey foundSurvey = surveyMain.getSurveyByName(testSurvey);
		
		if(foundSurvey != null) {
			return;
		} else {
			fail("Fail get survey by name");
		}	
	}
	
	@Test
	void testAddQuestionToSurvey() {

		surveyMain.addSurvey(testSurvey);
		Survey foundSurvey = surveyMain.getSurveyByName(testSurvey);
		
		lBefore = foundSurvey.getQuestions().size();
		surveyMain.addQuestionToSurvey(foundSurvey.getId(), testQuestion);
		lAfter = foundSurvey.getQuestions().size();
		
		if(lBefore < lAfter) {
			return;
		} else {
			fail("Fail add question to survey");
		}	
	}
	
	@Test
	void testAddResponseToSurvey() {
		
		surveyMain.addSurvey(testSurvey);
		Survey survey = surveyMain.getSurveyByName(testSurvey);
		
		lBefore = survey.getResponses().size();
		surveyMain.addResponseToSurvey(survey.getId());
		lAfter = survey.getResponses().size();
		
		if(lBefore < lAfter) {
			return;
		} else {
			fail("Fail add response to survey");
		}
	}
	
	@Test
	void testAddAnswerToResponse() {

		surveyMain.addSurvey(testSurvey);
		Survey survey = surveyMain.getSurveyByName(testSurvey);
		
		surveyMain.addQuestionToSurvey(survey.getId(), testQuestion);
		surveyMain.addResponseToSurvey(survey.getId());
		
		SurveyResponse testResponse = survey.getResponses().get(0);
		Question foundQuestion =  survey.getQuestions().get(0);
		
		lBefore = testResponse.getAnswers().size();
		surveyMain.addAnswerToResponse(survey.getId(), testResponse.getId(), foundQuestion, 3);
		lAfter = testResponse.getAnswers().size();
		
		
		if(lBefore < lAfter) {
			return;
		} else {
			fail("Fail add answer to response");
		}
	}
	
	@Test
	void testGetSurveyAverage() {

		Survey testSur = surveyMain.createTestSurvey();
		
		double testAverage = surveyMain.getSurveyAverage(testSur);
		
		double assertAverage = 0;
		int totalAnswers = 0;
		double totalScore = 0;
		
		for(SurveyResponse resp: testSur.getResponses()) {
			
			for(Answer answer: resp.getAnswers()) {
				totalAnswers++;
				totalScore = totalScore + answer.getScore();
			}
		}
		
		assertAverage = totalScore / totalAnswers;
		
		assertEquals(assertAverage, testAverage, "Average is not correct");
	}
	
	

}
