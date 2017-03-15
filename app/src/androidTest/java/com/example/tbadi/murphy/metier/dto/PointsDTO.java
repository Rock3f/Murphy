package com.example.tbadi.murphy.metier.dto;

import android.database.Cursor;

import com.example.tbadi.murphy.metier.BaseContrat;

public class PointsDTO
{

    // Attributs :
    private int nb_points = 0;


    public PointsDTO(int nb_points)
    {
        this.nb_points = nb_points;
    }


    public int getNbPoints()
    {
        return nb_points;
    }

    public void setNbpoints(int nb_points)
    {
        this.nb_points = nb_points;
    }

    public static PointsDTO getNbPointsDepuisCursor(Cursor cursor)
    {
        return new PointsDTO(
                cursor.getInt(cursor.getColumnIndex(BaseContrat.PointsContrat.COLONNE_NB_POINTS))
        );
    }

}