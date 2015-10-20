package oic.team_universe.alice;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends Activity  {
    @Override
    public void onCreate(Bundle savedInstanceState){
        Log.d("MainActivty", "MainActivty");
        super.onCreate(savedInstanceState);
        setContentView(new aliceSurfaceView(this));
    }

}
