package com.example.test;

import android.os.Bundle;
import android.app.Activity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
	private final String defaut ="Vous devez cliquer sur le bouton calculer l'IMC";
	private final String megamessage ="t'es trop maigre ma pauvre";
	EditText poids = null;
    EditText taille = null;
    Button calcul = null;
    Button raz = null;
    CheckBox mega = null;
    RadioGroup radio= null;
	TextView resultat = null;
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        poids = (EditText) findViewById(R.id.poids);
        taille = (EditText) findViewById(R.id.taille);
        calcul = (Button) findViewById(R.id.calcul);
        raz = (Button) findViewById(R.id.raz);
        mega = (CheckBox) findViewById(R.id.mega);
        radio= (RadioGroup) findViewById(R.id.group);
        resultat = (TextView) findViewById(R.id.result);
        
        raz.setOnClickListener(razlistener);
        calcul.setOnClickListener(envoyerListener);
        poids.addTextChangedListener(textWatcher);
        taille.addTextChangedListener(textWatcher);
        mega.setOnClickListener(checkedListener);
        
	}
	
	
        OnClickListener razlistener = new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				poids.getText().clear();
				taille.getText().clear();
				resultat.setText(defaut);
				
				
			}
		};
        
    
        OnClickListener envoyerListener = new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if(!mega.isChecked()){
					
					String t = taille.getText().toString();
						
					String p = poids.getText().toString();
					
					float tValue = Float.valueOf(t);
					if(tValue==0){
						Toast.makeText(MainActivity.this, "hého t'es un mini pouce ",  Toast.LENGTH_SHORT).show();
						
					}
					else {
						float pValue = Float.valueOf(p);
						if(radio.getCheckedRadioButtonId ()==R.id.radio2){
						tValue = tValue / 100;
						
						  tValue = (float)Math.pow(tValue, 2);
				          float imc = pValue / tValue;
				          resultat.setText("Votre IMC est " + String.valueOf(imc));
				        }
						else  resultat.setText(megamessage);
				      } 
					
				    
						
						}
					}
				
				
				
			};
		
		
		private TextWatcher textWatcher = new TextWatcher() {
			
			@Override
			public void onTextChanged(CharSequence s, int start, int before, int count) {
				// TODO Auto-generated method stub
				resultat.setText(defaut);
				
			}
			
			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void afterTextChanged(Editable s) {
				// TODO Auto-generated method stub
				
			}
		};
		
		
		private OnClickListener checkedListener = new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if(!((CheckBox)v).isChecked() && resultat.getText().equals(megamessage))
			        resultat.setText(defaut);
				// TODO Auto-generated method stub
				
			}
		};

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
