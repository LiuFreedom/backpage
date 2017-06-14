package com.kelan.animalsystem.DB;

import android.content.ContentValues;

import java.util.List;
import java.util.Map;

/**
 * Created by Ocean Liu on 2017/6/14/0014.
 */

public interface DBService {

    public boolean add(ContentValues values);

    public boolean delete(String whereClause, String[] whereArgs);

    public boolean update(ContentValues values, String whereClause, String[] whereArgs);

    public Map<String, String> mapView(String selection, String[] selectionArgs);

    public List<Map<String, String>> listViews(String selection, String[] selectionArgs);
}
