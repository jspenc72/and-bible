package net.bible.android.view.activity.readingplan.actionbar;

import net.bible.android.view.activity.base.actionbar.ActionBarManager;
import net.bible.android.view.activity.speak.actionbarbuttons.SpeakStopActionBarButton;
import net.bible.service.device.speak.event.SpeakEvent;
import net.bible.service.device.speak.event.SpeakEventListener;
import net.bible.service.device.speak.event.SpeakEventManager;
import android.app.Activity;
import android.support.v7.app.ActionBar;
import android.view.Menu;

public class ReadingPlanActionBarManager implements ActionBarManager {

	private ReadingPlanTitle readingPlanTitle = new ReadingPlanTitle();
	private BibleActionBarButton bibleActionBarButton = new BibleActionBarButton();
	private CommentaryActionBarButton commentaryActionBarButton = new CommentaryActionBarButton();
	private DictionaryActionBarButton dictionaryActionBarButton = new DictionaryActionBarButton();

	private PauseActionBarButton pauseActionBarButton = new PauseActionBarButton();
	private SpeakStopActionBarButton speakStopActionBarButton = new SpeakStopActionBarButton();

	
	public ReadingPlanActionBarManager() {
		// the manager will also instantly fire a catch-up event to ensure state is current
        SpeakEventManager.getInstance().addSpeakEventListener(new SpeakEventListener() {
			@Override
			public void speakStateChange(SpeakEvent e) {
				updateButtons();
			}
		});
    }

	public void prepareOptionsMenu(Activity activity, Menu menu, ActionBar actionBar) {
		readingPlanTitle.addToBar(actionBar, activity);
		
		bibleActionBarButton.addToMenu(menu);
		commentaryActionBarButton.addToMenu(menu);
		dictionaryActionBarButton.addToMenu(menu);
		
		pauseActionBarButton.addToMenu(menu);
		speakStopActionBarButton.addToMenu(menu);
	}
	
	public void updateButtons() {
		readingPlanTitle.update();
		
		bibleActionBarButton.update();
		commentaryActionBarButton.update();
		dictionaryActionBarButton.update();
		
		pauseActionBarButton.update();
		speakStopActionBarButton.update();
	}
}
