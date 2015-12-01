package oic.team_universe.alice;

import android.graphics.Canvas;
import android.util.Log;

public class Game_Initialize extends Task {


    /**
     *public class Game_Initialize {
     * static boolean initialize(){
     *      return true;
     *}
     *}
     *///旧
    @Override
    public boolean onUpdata(){
        Log.d("SurfaceView_G_UPDATA1", "Initialize");
        return true;
    }
    @Override
    public void onDraw(Canvas canvas){
        Log.d("SurfaceView_G_DRAW1", "Initialize");
    }

    static boolean Initialize_flag(){
        return true;
    }
}