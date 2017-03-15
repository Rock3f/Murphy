package com.example.tbadi.murphy.metier.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;


import com.example.tbadi.murphy.metier.BaseContrat;
import com.example.tbadi.murphy.metier.dbhelpers.DatabaseHelper;
import com.example.tbadi.murphy.metier.dto.NiveauDTO;

import java.util.ArrayList;
import java.util.List;

public class NiveauDAO
{

	public List<NiveauDTO> getListeNiveau(Context context)
	{
		// projection (colonnes utilisées après la requète) :
		String[] projection = {BaseContrat.NiveauContrat._ID,
				BaseContrat.NiveauContrat.COLONNE_INTITULE,
				BaseContrat.NiveauContrat.COLONNE_VALIDE};

		// tri :
		String tri = BaseContrat.NiveauContrat.COLONNE_INTITULE + " ASC " ;

		// accès en lecture (query) :
		DatabaseHelper databaseHelper = new DatabaseHelper(context);
		SQLiteDatabase db = databaseHelper.getReadableDatabase();

		// requête :
		Cursor cursor = db.query(
				BaseContrat.NiveauContrat.TABLE_NIVEAU,	// table sur laquelle faire la requète
				projection,									// colonnes à retourner
				null,										// colonnes pour la clause WHERE (inactif)
				null,										// valeurs pour la clause WHERE (inactif)
				null,										// GROUP BY (inactif)
				null,										// HAVING (inactif)
				tri,										// ordre de tri
				null);										// LIMIT (inactif)

		// construction de la liste de niveaux
		List<NiveauDTO> listeNiveau = new ArrayList<>();
		if (cursor != null)
		{
			try
			{
				cursor.moveToFirst();
				while (!cursor.isAfterLast())
				{
					// conversion des données remontées en un objet métier :
					listeNiveau.add(NiveauDTO.getNiveauDepuisCursor(cursor));
					cursor.moveToNext();
				}
			}
			catch (Exception exception)
			{
				exception.printStackTrace();
			}
			finally
			{
				cursor.close();
			}
		}

		return listeNiveau;
	}

}
