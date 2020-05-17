package testing;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import classes.Question;
import classes.Survey;
import classes.SurveyResponse;
import classes.Answer;
import main.SurveyMain;


class SurveyTest {
	
	private SurveyMain surveyMain = new SurveyMain();
	private ArrayList<Survey>surveys = surveyMain.getAllSurveys();
	private int lBefore, lAfter;
	
	@Test
	void testAddSurvey() {
		
		lBefore = surveys.size();
		surveyMain.addSurvey("Test Survey");
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
		String testValue = "Test Survey";
		surveyMain.addSurvey(testValue);
		Survey testSurvey = surveyMain.getSurveyByName(testValue);
		
		if(testSurvey != null) {
			return;
		} else {
			fail("Fail get survey by name");
		}	
	}
	
	@Test
	void testAddResponseToSurvey() {
		String testName = "Test Survey";
		surveyMain.addSurvey(testName);
		Survey survey = surveyMain.getSurveyByName(testName);
		
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
		String testName = "Test Survey";
		String testQstn = "Test Q1";
		surveyMain.addSurvey(testName);
		Survey survey = surveyMain.getSurveyByName(testName);
		
		surveyMain.addQuestionToSurvey(survey.getId(), testQstn);
		surveyMain.addResponseToSurvey(survey.getId());
		
		SurveyResponse testResponse = survey.getResponses().get(0);
		Question testQuestion =  survey.getQuestions().get(0);
		
		lBefore = testResponse.getAnswers().size();
		surveyMain.addAnswerToResponse(survey.getId(), testResponse.getId(), testQuestion, 3);
		lAfter = testResponse.getAnswers().size();
		
		
		if(lBefore < lAfter) {
			return;
		} else {
			fail("Fail add answer to response");
		}
	}

}
