package au.edu.jcu.cp3406.assignment1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TableRow;

import java.util.Random;


public class Control extends AppCompatActivity {
    private final Random random = new Random();
    private int index = 0;
    private final int[] drawables = {
            R.drawable.baseline_water_drop_black_48,
            R.drawable.fan_1,
            R.drawable.baseline_settings_power_black_48,
    };

    private void addImage() {
        // this is find the id of gameRows
        ViewGroup controlRows = findViewById(R.id.control_rows);
        //insert image.xml -> gameRows component (activity_game.xml);
        getLayoutInflater().inflate(R.layout.image, controlRows);
        //
        View lastChild = controlRows.getChildAt(controlRows.getChildCount() - 1);
        ImageView image = lastChild.findViewById(R.id.image);

//        for (int index = 0; index < 3; index++) {
            Resources resources = getResources();
        image.setImageDrawable(resources.getDrawableForDensity(drawables[index], 0));
//        }
        index +=1;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_control);
        for (int i = 0; i < 3; i++) {
            addImage();
            addLevelRadio(R.array.levels);
        }
    }

    private void addLevelRadio(int arrayID) {
        ViewGroup controlRows = findViewById(R.id.control_rows);
        getLayoutInflater().inflate(R.layout.levelchecker, controlRows);
        getLayoutInflater().inflate(R.layout.timechecker, controlRows);

        View lastChild = controlRows.getChildAt(controlRows.getChildCount()-1);
        RadioGroup radioGroup = (RadioGroup) lastChild.findViewById(R.id.levelchecker);
    }

    public void Apply(View view) {
        Intent intent = new Intent(this, notification.class);
        startActivity(intent);
    }
}