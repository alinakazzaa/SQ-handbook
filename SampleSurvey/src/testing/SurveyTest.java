package testing;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import classes.Survey;
import main.SurveyMain;

class SurveyTest {
	
	private SurveyMain surveyMain = new SurveyMain();
	private ArrayList<Survey>surveys = surveyMain.getAllSurveys();

	@Test
	void testAddSurvey() {
		
		int lBefore, lAfter;
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

}
