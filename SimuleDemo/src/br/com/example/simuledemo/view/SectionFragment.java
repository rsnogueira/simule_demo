package br.com.example.simuledemo.view;

import br.com.example.simuledemo.R;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;


/**
 * A fragment representing a section of the app
 */
public class SectionFragment extends Fragment {
	
	private int mCurrentPage;
	private String mQuestion;
	private String[] mAnswers;
	private RadioGroup rg = null;
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
                 
        /** Getting the arguments to the Bundle object */
        Bundle data = getArguments();        
 
        /** Getting integer data of the key current_page from the bundle */
        mCurrentPage = data.getInt("current_page", 0);
        mQuestion = data.getString("question", ""); 
        mAnswers = data.getStringArray("answers");        
    }
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.fragment_layout, container,false);        
        
        TextView question = (TextView ) v.findViewById(R.id.question);        
        question.setText(mQuestion);
        
        rg = (RadioGroup) v.findViewById(R.id.radio_group);    	
    	RadioButton[] button = new RadioButton[mAnswers.length];
    	            	
    	for (int i = 0; i < mAnswers.length; i++) {
			button[i] = new RadioButton(v.getContext());
			rg.addView(button[i]);			
			button[i].setText(mAnswers[i]);						
		}
        
        TextView tv = (TextView ) v.findViewById(R.id.tv);
        tv.setText("You are viewing the page #" + mCurrentPage + "\n\n" + "Swipe Horizontally left / right");
        return v;
	}		
}
	

