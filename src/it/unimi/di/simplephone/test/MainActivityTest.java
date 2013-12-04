package it.unimi.di.simplephone.test;

import it.unimi.di.simplephone.MainActivity;
import it.unimi.di.simplephone.R;
import it.unimi.di.simplephone.R.id;
import android.content.Intent;
import android.test.ActivityUnitTestCase;
import android.test.TouchUtils;
import android.test.ViewAsserts;
import android.test.suitebuilder.annotation.MediumTest;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivityTest extends ActivityUnitTestCase<MainActivity>{

	private MainActivity mMainActivity;
    private View mMainActivityTest;
    private TextView mtextViewTest;
    
    final Button mcontactButton = (Button) 
    		mMainActivity.findViewById(it.unimi.di.simplephone.R.id.buttonContact);

    final TextView mtextView1 = (TextView) 
    		mMainActivity.findViewById(R.id.textView1);
    

    final Button mcallButton = (Button) 
    		mMainActivity.findViewById(it.unimi.di.simplephone.R.id.buttonCall);

	
	public MainActivityTest() {
		super(MainActivity.class);

		//super("it.unimi.di.simplephone.test",MainActivity.class);
// TODO Auto-generated constructor stub
	}
	
	protected void setUp() throws Exception{ //setup
		super.setUp();
		
		
		
		mMainActivity = this.getActivity();
		 
		mMainActivityTest = (View) mMainActivity.findViewById(id.listView1);
		
		Intent nLaunchIntent = new Intent(getInstrumentation().getTargetContext(),MainActivity.class);
		startActivity(nLaunchIntent,null,null);
		
	}
	
	 @MediumTest
	    public void testClickMeButton_layout() {
	        //Retrieve the top-level window decor view
	        final View decorView = mMainActivity.getWindow().getDecorView();

	        //Verify that the mClickMeButton is on screen
	        ViewAsserts.assertOnScreen(decorView, mcontactButton);

	        //Verify width and heights
	        final ViewGroup.LayoutParams layoutParams = mcontactButton.getLayoutParams();
	        assertNotNull(layoutParams);
	        assertEquals(layoutParams.width, WindowManager.LayoutParams.MATCH_PARENT);
	        assertEquals(layoutParams.height, WindowManager.LayoutParams.WRAP_CONTENT);
	    }

	    @MediumTest
	public void testPreconditions() {
        assertNotNull("mMainActivity is null", mMainActivity);
        assertNotNull("mcontactButton is null", mcontactButton);
        assertNotNull("msenderMessageEditText is null", mtextView1);
        assertNotNull("mcallButton is null", mcallButton);
    }
	    @MediumTest
	    public void testContactButton_labelText() {
	        //Verify that mClickMeButton uses the correct string resource
	        final String expectedNextButtonText = mMainActivity.getString(R.string.contact);
	        final String actualNextButtonText = mcontactButton.getText().toString();
	        assertEquals(expectedNextButtonText, actualNextButtonText);
	    }
	    
	    @MediumTest
	    public void testCallButton_labelText() {
	        //Verify that mClickMeButton uses the correct string resource
	        final String expectedNextButtonText = mMainActivity.getString(R.string.contact);
	        final String actualNextButtonText = mcallButton.getText().toString();
	        assertEquals(expectedNextButtonText, actualNextButtonText);
	    }

	    @MediumTest
	    public void testInfoTextView_layout() {
	        //Retrieve the top-level window decor view
	        final View decorView = mMainActivity.getWindow().getDecorView();

	        //Verify that the mInfoTextView is on screen and is not visible
	        ViewAsserts.assertOnScreen(decorView, mtextView1);
	        assertTrue(View.GONE == mtextView1.getVisibility());
	    }

	    @MediumTest
	    public void testInfoTextViewText_isEmpty() {
	        //Verify that the mInfoTextView is initialized with the correct default value
	        assertEquals("", mtextView1.getText());
	    }

	    @MediumTest
	    public void testCallButton_clickButtonAndExpectInfoText() {
	        String expectedInfoText = mMainActivity.getString(R.string.contact);
	        //Perform a click on mClickMeButton
	        TouchUtils.clickView(this, mcallButton);
	        //Verify the that mClickMeButton was clicked. mInfoTextView is visible and contains
	        //the correct text.
	        assertTrue(View.VISIBLE == mtextView1.getVisibility());
	        assertEquals(expectedInfoText, mtextView1.getText());
	    
	    }
	    
	    @MediumTest
	    public void testContactButton_clickButtonAndExpectInfoText() {
	        String expectedInfoText = mMainActivity.getString(R.string.contact);
	        //Perform a click on mClickMeButton
	        TouchUtils.clickView(this, mcontactButton);
	        //Verify the that mClickMeButton was clicked. mInfoTextView is visible and contains
	        //the correct text.
	        assertTrue(View.VISIBLE == mtextView1.getVisibility());
	        assertEquals(expectedInfoText, mtextView1.getText());
	    }
	}