package oic.team_universe.alice;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class AliceSurfaceView extends SurfaceView implements SurfaceHolder.Callback,Runnable {
    private Game_Mgr game_mgr = new Game_Mgr();
    private SurfaceHolder holder = null;
    private Thread thread = null;
    private boolean isAttached = true;
    //private int nRoutineNo = 1;

    //コンストラクタ
    public AliceSurfaceView(Context context) {
        super(context);
        //リソースオブジェクト作成
        Resources res =this.getContext().getResources();
        Log.d("SurfaceView2", "SurfaceView2");
        //コールバックに返却
        getHolder().addCallback(this);

    }

    @Override//SurfaceView変換時
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
        Log.d("SurfaceChanged", "SurfaceChanged");
    }

    @Override//SurfaceView生成時
    public void surfaceCreated(SurfaceHolder holder) {
        Log.d("SurfaceCreated", "SurfaceCreated");
        this.holder=holder;
        thread = new Thread(this);
        thread.start();
    }

    @Override//SurfaceView破棄時
    public void surfaceDestroyed(SurfaceHolder holder) {
        Log.d("SurfaceDestroyed", "SurfaceDestroyed");
        isAttached = false;
        thread = null; //スレッドを終了
    }

    @Override//SurfaceView実行時
    public void run(){
            while(isAttached) {
                Log.d("SurfaceRun", "SurfaceRun");

                //Todo 移動処理
                doMove();
                //Todo 描画処理
                doDraw();
            }
    }

    private void doMove(){
        Log.d("SurfaceMove", "SurfaceMove");
        //game_mgr.state();
        game_mgr.onUpdate();
    }
    /**
         * Paint paint = new Paint();
         * canvas.rotate(45.0f);
         * canvas.drawColor(Color.WHITE);//背景
         * paint.setColor(Color.BLUE);//文字色
         * paint.setAntiAlias(true);
         * paint.setTextSize(24);
         * canvas.drawText("Hello, World", paint.getTextSize(), 0, paint);
     *///Drawテスト用
    private void doDraw(){
        //画面をロック
        Canvas canvas = getHolder().lockCanvas();
        Log.d("SurfaceDraw", "SurfaceDraw");//Todo テストログ

        //Todo テスト用
        canvas.save(); //状態を保存

        game_mgr.onDraw(canvas);

        canvas.restore(); // 状態を復元
        //画面のロック解除
        getHolder().unlockCanvasAndPost(canvas);
    }
}
