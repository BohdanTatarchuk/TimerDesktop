package com.example.timerpc;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.util.Duration;

public class Controller{

    Timeline clock;
    int mil = 0;
    int sec = 0;
    int min = 0;
    int h = 0;

    @FXML
    private Label time;

    @FXML
    void onPlay(ActionEvent event) {
        clock = new Timeline(new KeyFrame(Duration.millis(1), actionEvent -> update(time)));
        clock.setCycleCount(Timeline.INDEFINITE);
        clock.setAutoReverse(false);
        System.out.println("Begin");
        clock.play();
    }

    @FXML
    void onReset(ActionEvent event) {
        clock.stop();
        mil = 0;
        sec = 0;
        min = 0;
        h = 0;
        time.setText("00:00:00:000");
    }

    @FXML
    void onStop(ActionEvent event) {
        clock.stop();
    }

    void update(Label time){
        if(mil == 1000){
            mil = 0;
            sec++;
        }
        if(sec == 60){
            min++;
            sec = 0;
        }
        if(min == 60){
            h++;
            min = 0;
            sec = 0;
            mil = 0;
        }

        time.setText(h + ":" + (((min/10) == 0) ? "0":"") + min + ":" + (((sec/10) == 0) ? "" : "") + sec + ":" +
                (((mil/10) == 0) ? "80" : (((mil/100) == 0) ? "0" : "")) +mil++);
        String s = h+":"+min+":"+sec+":"+mil;
        System.out.println(s);
    }
}