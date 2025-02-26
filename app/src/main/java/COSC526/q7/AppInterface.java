package COSC526.q7;

import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class AppInterface extends RelativeLayout {
    private GridLayout currentBoardLayout, goalBoardLayout;
    private TextView[][] currentBoard;
    private TextView[][] goalBoard;
    private Button upButton;
    private Button downButton;
    private Button leftButton;
    private Button rightButton;
    private GridLayout.LayoutParams gridParams;
    public AppInterface(Context context, View.OnClickListener buttonHandler)
    {
        super(context);
        final int DP = (int)(getResources().getDisplayMetrics().density);
        //Create the current board
        currentBoardLayout = new GridLayout(context);
        currentBoardLayout.setRowCount(3);
        currentBoardLayout.setColumnCount(3);

        //create goal board
        goalBoardLayout = new GridLayout(context);
        goalBoardLayout.setRowCount(3);
        goalBoardLayout.setColumnCount(3);

        //initialize textviews array for current and goal boards
        currentBoard = new TextView[3][3];
        goalBoard = new TextView[3][3];

        //create Textview for current board
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                currentBoard[i][j] = new TextView(context);
                currentBoard[i][j].setTextSize(30);
                currentBoard[i][j].setPadding(50,20, 50, 20);
                currentBoard[i][j].setGravity(Gravity.CENTER);
                currentBoard[i][j].setTextColor(Color.parseColor("#F8F7F3"));
                currentBoardLayout.addView(currentBoard[i][j]);
            }
        }

        //create Textview for goal board
        for (int i = 0; i < 3 ; i++) {
            for (int j = 0; j < 3; j++) {
                goalBoard[i][j] = new TextView(context);
                goalBoard[i][j].setPadding(50,20, 50, 20);
                goalBoard[i][j].setTextSize(30);
                goalBoard[i][j].setGravity(Gravity.CENTER);
                goalBoard[i][j].setTextColor(Color.parseColor("#F8F7F3"));

                goalBoardLayout.addView(goalBoard[i][j]);
            }
        }

        //create four buttons
        upButton = new Button(context);
        upButton.setText("Up");
        upButton.setTextSize(25);
        upButton.setPadding(40,40,40,40);
        upButton.setBackgroundColor(Color.parseColor("#005B96"));
        upButton.setTextColor(Color.parseColor("#F8F7F3"));
        upButton.setOnClickListener(buttonHandler);

        downButton = new Button(context);
        downButton.setText("Down");
        downButton.setTextSize(25);
        downButton.setPadding(40,40,40,40);
        downButton.setBackgroundColor(Color.parseColor("#005B96"));
        downButton.setTextColor(Color.parseColor("#F8F7F3"));
        downButton.setOnClickListener(buttonHandler);

        rightButton = new Button(context);
        rightButton.setText("Right");
        rightButton.setTextSize(25);
        rightButton.setPadding(40,40,40,40);
        rightButton.setBackgroundColor(Color.parseColor("#005B96"));
        rightButton.setTextColor(Color.parseColor("#F8F7F3"));
        rightButton.setOnClickListener(buttonHandler);

        leftButton = new Button(context);
        leftButton.setText("Left");
        leftButton.setTextSize(25);
        leftButton.setPadding(40,40,40,40);
        leftButton.setBackgroundColor(Color.parseColor("#005B96"));
        leftButton.setTextColor(Color.parseColor("#F8F7F3"));
        leftButton.setOnClickListener(buttonHandler);


        //add buttons and grids to the layout
        RelativeLayout.LayoutParams gridParams1 = new RelativeLayout.LayoutParams(
                LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        RelativeLayout.LayoutParams gridParams2 = new RelativeLayout.LayoutParams(
                LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        RelativeLayout.LayoutParams upButtonParams = new RelativeLayout.LayoutParams(
                LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        RelativeLayout.LayoutParams downButtonParams = new RelativeLayout.LayoutParams(
                LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        RelativeLayout.LayoutParams rightButtonParams = new RelativeLayout.LayoutParams(
                LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        RelativeLayout.LayoutParams leftButtonParams = new RelativeLayout.LayoutParams(
                LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        gridParams1.addRule(RelativeLayout.CENTER_HORIZONTAL);
        gridParams1.topMargin = 60 *DP;
        currentBoardLayout.setBackgroundColor(Color.parseColor("#2D94AC"));
        currentBoardLayout.setLayoutParams(gridParams1);

        gridParams2.addRule(RelativeLayout.CENTER_HORIZONTAL);
        gridParams2.topMargin = 360*DP;
        goalBoardLayout.setBackgroundColor(Color.parseColor("#2D94AC"));
        goalBoardLayout.setLayoutParams(gridParams2);
        // up button params
        upButtonParams.topMargin = 650*DP;
        upButtonParams.leftMargin = 40* DP;
        upButton.setLayoutParams(upButtonParams);

        //down button params
        downButtonParams.topMargin = 650*DP;
        downButtonParams.leftMargin = 146* DP;
        downButton.setLayoutParams(downButtonParams);

        //right button params
        rightButtonParams.topMargin = 650*DP;
        rightButtonParams.leftMargin = 272*DP;
        rightButton.setLayoutParams(rightButtonParams);

        //left button params
        leftButtonParams.topMargin = 650*DP;
        leftButtonParams.leftMargin = 396*DP;
        leftButton.setLayoutParams(leftButtonParams);

        addView(currentBoardLayout);
        addView(goalBoardLayout);
        addView(upButton);
        addView(downButton);
        addView(rightButton);
        addView(leftButton);

    }

    public void drawCurrent(char[][] current){
        // display contents of current board
        for(int i = 0; i < 3; i ++){
            for(int j = 0; j < 3; j++){
                currentBoard[i][j].setText(String.valueOf(current[i][j]));
            }
        }
    }
    public void drawGoal(char[][] goal){
        //display contents of goal board
        for(int i = 0; i < 3; i ++){
            for(int j = 0; j < 3; j++){
                goalBoard[i][j].setText(String.valueOf(goal[i][j]));
            }
        }

    }
    public int findButton(Button button ){
        //compare button with four buttons and return 1, 2, 3, 4
        if(button == upButton){
            return 1;
        } else if (button == downButton) {
            return 2;
        } else if (button == rightButton) {
            return 3;
        }else if(button == leftButton){
            return 4;
        }
        return -1;

    }
    public void disableButtons(){
        //disable buttons method
        upButton.setEnabled(false);
        downButton.setEnabled(false);
        rightButton.setEnabled(false);
        leftButton.setEnabled(false);
    }

}
