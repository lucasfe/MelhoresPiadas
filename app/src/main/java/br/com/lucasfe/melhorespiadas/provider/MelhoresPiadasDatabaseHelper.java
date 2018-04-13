package br.com.lucasfe.melhorespiadas.provider;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import br.com.lucasfe.melhorespiadas.provider.model.PiadaModel;

public class MelhoresPiadasDatabaseHelper extends SQLiteOpenHelper {


    private static final String TAG = MelhoresPiadasDatabaseHelper.class.getSimpleName();

    private Context mContext;

    private static final String DATABASE_NAME = "piadas.db";
    private static final int DATABASE_VERSION = 3;
    private static final String DATABASE_ASSETS_PATH = "database/piadas.db";


    public MelhoresPiadasDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        mContext = context;
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(PiadaModel.CREATE_PIADAS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }


    public void importDatabase() throws IOException, SQLiteException {

        String currentDBPath = mContext.getDatabasePath(DATABASE_NAME).getAbsolutePath();

        // Close current database to flush resources
        close();

        InputStream is = mContext.getAssets().open(DATABASE_ASSETS_PATH);
        FileOutputStream os = new FileOutputStream(currentDBPath);

        // Copy the backed up database into the current one
        copyFile(is, os);

        is.close();
        os.flush();
        os.close();

        // Access the copied database so SQLiteHelper will cache it and mark
        // it as created.
        getWritableDatabase();


        Log.i(TAG, "Successfully imported bootup database");
    }

    private void copyFile(InputStream in, OutputStream out) throws IOException {
        byte[] buffer = new byte[1024];
        int read;
        while ((read = in.read(buffer)) != -1) {
            out.write(buffer, 0, read);
        }
    }

}
