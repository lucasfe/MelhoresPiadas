package br.com.lucasfe.melhorespiadas.provider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import br.com.lucasfe.melhorespiadas.provider.model.MelhoresPiadas;

public class PiadasProvider extends ContentProvider{

    private static final String TAG = PiadasProvider.class.getSimpleName();

    private MelhoresPiadasDatabaseHelper mDBHelper;

    private static final int URI_PIADA = 1;
    private static final int URI_PIADA_ID = 2;

    private static final UriMatcher sUriMatcher;


    static {

        sUriMatcher = new UriMatcher(UriMatcher.NO_MATCH);

        sUriMatcher.addURI(MelhoresPiadas.AUTHORITY, "piada", URI_PIADA);
        sUriMatcher.addURI(MelhoresPiadas.AUTHORITY, "piada/#", URI_PIADA_ID);
    }

    @Override
    public boolean onCreate() {
        mDBHelper = new MelhoresPiadasDatabaseHelper(getContext());
        return true;
    }

    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri, @Nullable String[] projection, @Nullable String selection, @Nullable String[] selectionArgs, @Nullable String sortOrder) {
        return null;
    }

    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {
        return null;
    }

    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues values) {
        return null;
    }

    @Override
    public int delete(@NonNull Uri uri, @Nullable String selection, @Nullable String[] selectionArgs) {
        return 0;
    }

    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues values, @Nullable String selection, @Nullable String[] selectionArgs) {
        return 0;
    }
}
