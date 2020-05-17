package classes;
import java.util.ArrayList;


public class SurveyResponse {
	
	private int id;
	private ArrayList<Answer> answers = new ArrayList<Answer>();

	
	public int getId() {
		return id;
	}

	public SurveyResponse(int id) {
		super();
		this.id = id;
	}

	public ArrayList<Answer> getAnswers() {
		return answers;
	}

	public void addAnswer(Answer answer) {
		this.answers.add(answer);
	}	
}
