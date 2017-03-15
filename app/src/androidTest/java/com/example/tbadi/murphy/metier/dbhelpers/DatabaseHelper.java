package com.example.tbadi.murphy.metier.dbhelpers;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.tbadi.murphy.metier.BaseContrat;

public class DatabaseHelper extends SQLiteOpenHelper
{

	// Constantes :
	private static final String NOM_DATABASE = "murphy.db";
	private static final int VERSION_DATABASE = 1;
	private static final String CREATE_TABLE_NIVEAU = "CREATE TABLE " + BaseContrat.NiveauContrat.TABLE_NIVEAU + " ("
			+ BaseContrat.NiveauContrat._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
			+ BaseContrat.NiveauContrat.COLONNE_INTITULE + " TEXT NOT NULL, "
			+ BaseContrat.NiveauContrat.COLONNE_VALIDE + " INTEGER NOT NULL "
			+ ")";
	private static final String CREATE_TABLE_POINTS = "CREATE TABLE " + BaseContrat.PointsContrat.TABLE_POINTS + " ("
			+ BaseContrat.PointsContrat._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
			+ BaseContrat.PointsContrat.COLONNE_NB_POINTS + " INTEGER NOT NULL "
			+ ")";



	/**
	 * Constructeur.
	 * @param context Context
	 */
	public DatabaseHelper(Context context)
	{
		super(context, NOM_DATABASE, null, VERSION_DATABASE);
	}

	@Override
	public void onCreate(SQLiteDatabase db)
	{
		db.execSQL(CREATE_TABLE_NIVEAU);
		db.execSQL("INSERT INTO " + BaseContrat.NiveauContrat.TABLE_NIVEAU + " VALUES (NULL, '1', 0)");
		db.execSQL("INSERT INTO " + BaseContrat.NiveauContrat.TABLE_NIVEAU + " VALUES (NULL, '2', 0)");
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
	{
		db.execSQL("DROP TABLE IF EXISTS " + BaseContrat.NiveauContrat.TABLE_NIVEAU);
		onCreate(db);
		db.execSQL("DROP TABLE IF EXISTS " + BaseContrat.PointsContrat.TABLE_POINTS);
		onCreate(db);
	}

	@Override
	public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion)
	{
		onUpgrade(db, oldVersion, newVersion);
	}

}
