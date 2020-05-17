package testing;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import classes.Survey;
import main.SurveyMain;

class SurveyTest {
	
	private SurveyMain surveyMain;

	@Test
	void testAddSurvey() {
		
		surveyMain = new SurveyMain();
		ArrayList<Survey>surveys = surveyMain.getAllSurveys();
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
	
//	@Test
//	void test() {
//		surveyMain = new SurveyMain();
//		assertEquals(0, tester.multiply(10, 0), "10 x 0 must be 0");
//		fail("Not yet implemented");
//	}

}
