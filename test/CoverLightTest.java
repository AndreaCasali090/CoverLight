package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.awt.Point;
import java.awt.Rectangle;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import main.CanvasPanel;
import main.TutorialGUI;
import main.TutorialGUILogicImpl;

public class CoverLightTest {	
	
	@Nested
    class TutorialLogic{ //Subclass to separate the tests (you can now add Before/BeforeEach/After/Afterach for specific tests only)
		private TutorialGUILogicImpl tutorial;
		private TutorialGUI tutorialGUI;
		
		@BeforeEach
		public void setUp() {
			tutorial = new TutorialGUILogicImpl();
			tutorialGUI = new TutorialGUI();
		}
		
		@Test
		@DisplayName("check if zero")
		public void testZero() {
			assertEquals(0, tutorial.getSlideNumber(), "Slide number should be 0");
		}
		
		@Test
		@DisplayName("check if != zero")
		public void testEqualsZero() {
			tutorial.previousSlide();
			assertEquals(0, tutorial.getSlideNumber(), "Slide number should be 0");
		}

		@Test
		@DisplayName("check slide 1")
		public void testNext1() {
			assertEquals(0, tutorial.getSlideNumber(), "Slide number should be 0");
			tutorial.nextSlide();
			assertEquals(1, tutorial.getSlideNumber(), "Slide number should be 1");
		}
		
		@Test
		@DisplayName("check slide 2")
		public void testNext2() {
			tutorial.nextSlide();
			tutorial.nextSlide();
			assertEquals(2, tutorial.getSlideNumber(), "Slide number should be 2");
		}
		
		@Test
		@DisplayName("check slide 3")
		public void testNext3() {
			tutorial.nextSlide();
			tutorial.nextSlide();
			tutorial.nextSlide();
			assertEquals(3, tutorial.getSlideNumber(), "Slide number should be 3");
		}
		
		@Test
		@DisplayName("check slide 4")
		public void testNext4() {
			tutorial.nextSlide();
			tutorial.nextSlide();
			tutorial.nextSlide();
			tutorial.nextSlide();
			assertEquals(3, tutorial.getSlideNumber(), "Slide number should be 3 not 4");
		}
		
		@Test
		@DisplayName("check graphic slide 2")
		public void testSlideGUI() {
			tutorialGUI.getLogic().nextSlide();
			assertEquals(1, tutorialGUI.getLogic().getSlideNumber(), "Slide number should be 1");
			assertEquals(tutorialGUI.getSecondSlide(), tutorialGUI.getCurrectSlide(), "Graphic Slide number should be 2");
		}  
		
		@Test
		@DisplayName("check slide after arbitrary movements")
		public void testSlideGUI2() {
			tutorialGUI.getLogic().nextSlide();
			tutorialGUI.getLogic().nextSlide();
			tutorialGUI.getLogic().nextSlide();
			tutorialGUI.getLogic().previousSlide();;
			assertEquals(2, tutorialGUI.getLogic().getSlideNumber(), "Slide number should be 2");
			assertEquals(tutorialGUI.getThirdSlide(), tutorialGUI.getCurrectSlide(), "Graphic Slide number should be 3");
		}  
     }
	
	@Nested
    class CaptionLogic{ //Subclass to separate the tests (you can now add Before/BeforeEach/After/Afterach for specific tests only)
		public CanvasPanel panel;
		
		@BeforeEach
		public void setUp() {
			panel = new CanvasPanel();
		}		
		
		@Test
		@DisplayName("check graphical emitters add")
		public void testNext4() {
			panel.getLogic().setNewEmitter(new Rectangle(1,1,50,50), new Point(0,360));
			assertEquals(1, panel.getLogic().getEmitters().size(), "Graphical emitters size = 1");
		}
        
     }
}
