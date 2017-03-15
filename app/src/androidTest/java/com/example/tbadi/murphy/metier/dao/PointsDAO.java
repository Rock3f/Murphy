package com.example.tbadi.murphy.metier.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.tbadi.murphy.metier.BaseContrat;
import com.example.tbadi.murphy.metier.dbhelpers.DatabaseHelper;
import com.example.tbadi.murphy.metier.dto.PointsDTO;

import java.util.ArrayList;
import java.util.List;


public class PointsDAO
{

    public List<PointsDTO> getListePoints(Context context)
    {
        // projection (colonnes utilisées après la requète) :
        String[] projection = {BaseContrat.PointsContrat._ID,
                BaseContrat.PointsContrat.COLONNE_NB_POINTS};

        // tri :
        String tri = BaseContrat.PointsContrat.COLONNE_NB_POINTS ;

        // accès en lecture (query) :
        DatabaseHelper databaseHelper = new DatabaseHelper(context);
        SQLiteDatabase db = databaseHelper.getReadableDatabase();

        // requête :
        Cursor cursor = db.query(
                BaseContrat.PointsContrat.TABLE_POINTS,	// table sur laquelle faire la requète
                projection,									// colonnes à retourner
                null,										// colonnes pour la clause WHERE (inactif)
                null,										// valeurs pour la clause WHERE (inactif)
                null,										// GROUP BY (inactif)
                null,										// HAVING (inactif)
                tri,										// ordre de tri
                null);										// LIMIT (inactif)

        List<PointsDTO> listePoints = new ArrayList<>();
        if (cursor != null)
        {
            try
            {
                cursor.moveToFirst();
                while (!cursor.isAfterLast())
                {
                    // conversion des données remontées en un objet métier :
                    listePoints.add(PointsDTO.getNbPointsDepuisCursor(cursor));
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

        return listePoints;
    }

}