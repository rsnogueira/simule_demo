package br.com.example.simuledemo.view;

import java.util.ArrayList;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import entity.Question;

public class SectionsPagerAdapter extends FragmentPagerAdapter {

	ArrayList<Question> questionsList;
	
	public SectionsPagerAdapter(FragmentManager fm) {
		super(fm);
		questionsList = fillQuestionsList();
	}

	@Override
	public Fragment getItem(int position) {
		SectionFragment myFragment = new SectionFragment();
        Bundle data = new Bundle();
        data.putInt("current_page", position +1);
        data.putString("question", questionsList.get(position).getEnunciado());
        data.putStringArray("answers", questionsList.get(position).getRespostas());
        myFragment.setArguments(data);
        return myFragment;
	}

	@Override
	public int getCount() {
		return questionsList.size();
	}
	
	@Override
	public CharSequence getPageTitle(int position) {
		return "Quest�o " + (position + 1) + " de " + Integer.toString(questionsList.size());
	}
	
	private ArrayList<Question> fillQuestionsList(){
    	
    	Question question = new Question();
    	questionsList = new ArrayList<Question>();
    	String[] respostas = new String[] {"Resposta 1", "Resposta 2", "Resposta 3", "Resposta 4", "Resposta 5"};
    	
    	String Q1 = "Quando habilitado em mais de uma categoria, o condutor ter�:";    	
		question.setEnunciado(Q1);
		question.setRespostas(respostas);
		
    	questionsList.add(question);
    	
    	String Q2 = "Um silvo longo emitido pelo apito do agente de tr�nsito significa:";	
    	
    	question = new Question();
    	question.setEnunciado(Q2);
    	question.setRespostas(respostas);
    	questionsList.add(question);
    	
    	String Q3 = "O motorista defensivo deve saber que condi��es adversas s�o:";		
    	
    	question = new Question();
    	question.setEnunciado(Q3);
    	question.setRespostas(respostas);
    	questionsList.add(question);
    	
    	String Q4 = "Em uma ultrapassagem, a primeira vari�vel a ser analisada �:";	
    	
    	question = new Question();
    	question.setEnunciado(Q4);
    	question.setRespostas(respostas);
    	questionsList.add(question);
    	
    	String Q5 = "A velocidade m�xima de 60km/h � permitida, na aus�ncia de sinaliza��o, para a via urbana chamada de:";		
    	question = new Question();
    	question.setEnunciado(Q5);
    	question.setRespostas(respostas);
    	questionsList.add(question);	
    	
    	return questionsList;
    }

}
