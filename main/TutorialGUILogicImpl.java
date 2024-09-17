package main;

import javax.swing.JButton;

public class TutorialGUILogicImpl {
	private int tutorialSlideCounter;
	private static final int MIN_SLIDE = 0;
	private static final int MAX_SLIDE = 3;
	
	public TutorialGUILogicImpl() {
		tutorialSlideCounter = 0;
	}
	
	public void nextSlide() {
		tutorialSlideCounter = tutorialSlideCounter < MAX_SLIDE ? tutorialSlideCounter + 1 : tutorialSlideCounter;
	}
	
	public void previousSlide() {
		tutorialSlideCounter = tutorialSlideCounter > MIN_SLIDE? tutorialSlideCounter - 1 : tutorialSlideCounter;
	}

	public void buttonsLogic(JButton previousBtn, JButton nextBtn) {
		if (previousBtn.isEnabled() == false && (tutorialSlideCounter > MIN_SLIDE)) {
			previousBtn.setEnabled(true);
		}
		if (tutorialSlideCounter == MAX_SLIDE) {
			nextBtn.setEnabled(false);
		}
		if(nextBtn.isEnabled() == false && (tutorialSlideCounter < MAX_SLIDE)) {
			nextBtn.setEnabled(true);
		}
		if(tutorialSlideCounter == MIN_SLIDE) {
			previousBtn.setEnabled(false);
		}
	}
	
	public int getSlideNumber() {
		return this.tutorialSlideCounter;
	}
}
