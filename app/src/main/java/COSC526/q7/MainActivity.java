package COSC526.q7;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private Game game;
    private ButtonHandler buttonHandler;
    private AppInterface appInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //create game
        game = new Game();
        //create buttonhandler
        buttonHandler = new ButtonHandler();
        //create appinterface and pass buttonhandler
        appInterface = new AppInterface(this, buttonHandler);
        //setcontentview appinterface
        setContentView(appInterface);
        //get current board and display in appinterface
        appInterface.drawCurrent(game.getCurrentBoard());
        //get goal board and display in appinterface
        appInterface.drawGoal(game.getGoalBoard());
    }
    private class ButtonHandler implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            //find which button was clicked through the id
            int buttonID = appInterface.findButton((Button) v);
            //if 1, 2, 3, 4 move up, down, right, left
            if(buttonID == 1){
                game.up();
            }
            if(buttonID == 2){
                game.down();
            }
            if(buttonID == 3){
                game.right();
            }
            if(buttonID == 4){
                game.left();
            }
            //display current board
            appInterface.drawCurrent(game.getCurrentBoard());

            //if the player board matches the goal board a toast will appear
            if(game.getCurrentBoard() == game.getGoalBoard()){
                String text = "You completed the puzzle!";
                int duration = Toast.LENGTH_SHORT;
                Toast toast = Toast.makeText(MainActivity.this, text, duration);
                toast.show();
                appInterface.disableButtons();
            }
        }
    }
}