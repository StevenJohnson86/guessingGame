package stevenpjohnson.guessinggame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static class Answer{
        int answer = (int) (Math.random() * 20 + 1);
    }

    Answer ans = new Answer();
    int tries = 0;

    public void guessSubmit(View view){

        EditText guess = (EditText) findViewById(R.id.guessInput);

        if (guess.getText().length() == 0) return;


        if (Integer.parseInt(guess.getText().toString()) == ans.answer){
            //Toast "Correct!"
            Toast.makeText(this, "Correct", Toast.LENGTH_LONG).show();
            ans = new Answer();
            tries = 0;
        } else {
            tries++;
            if (Integer.parseInt(guess.getText().toString()) > ans.answer) {
                Toast.makeText(this, "Wrong, try lower! " + (5 - tries) + " guesses left!", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(this, "Wrong, try higher! " + (5 - tries) + " guesses left!", Toast.LENGTH_LONG).show();
            }
            if (tries >= 5) {
                Toast.makeText(this, "Your five guesses have been exhausted. Game restarted", Toast.LENGTH_LONG).show();
                tries = 0;
            }
            //Toast "wrong, guess again! __ more tries left"
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }
}
