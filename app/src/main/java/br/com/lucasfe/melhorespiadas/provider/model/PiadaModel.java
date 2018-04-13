package br.com.lucasfe.melhorespiadas.provider.model;

import android.net.Uri;
import android.provider.BaseColumns;

public class PiadaModel implements BaseColumns{

    public static final String TABLE_NAME = "piadas";

    public static final String TITLE = "title";
    public static final String DESCRIPTION = "description";
    public static final String CATEGORY = "category";


    /**
     * The content:// style URL for this table
     */
    public static final Uri CONTENT_URI = Uri.parse("content://" + MelhoresPiadas.AUTHORITY + "/piada");

    /**
     * The MIME type of {@link #CONTENT_URI} providing a directory of questions.
     */
    public static final String CONTENT_TYPE = "vnd.android.cursor.dir/vnd.melhorespiadas.piada";

    /**
     * The MIME type of a {@link #CONTENT_URI} sub-directory of a single question.
     */
    public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/vnd.melhorespiadas.piada";

    /**
     * Database creation statement
     */
    public static final String CREATE_PIADAS_TABLE = "create table "
            + TABLE_NAME + "("
            + _ID	+ " integer primary key autoincrement, "
            + TITLE + " text not null,"
            + DESCRIPTION + " text not null,"
            + CATEGORY + " integer);";


}
