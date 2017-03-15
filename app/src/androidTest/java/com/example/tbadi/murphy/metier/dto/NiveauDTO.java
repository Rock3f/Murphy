package com.example.tbadi.murphy.metier.dto;

import android.database.Cursor;

import com.example.tbadi.murphy.metier.BaseContrat;

public class NiveauDTO
{

	// Attributs :
	private String libelle = null;
	private int etatValide = 0;


	/**
	 * Constructeur.
	 * @param libelle libellé
	 * @param etatValide 0 si invalide, 1 si valide (si niveau validé)
	 */
	public NiveauDTO(String libelle, int etatValide)
	{
		this.libelle = libelle;
	}

	/**
	 * Getter libellé
	 * @return libelle
	 */
	public String getLibelle()
	{
		return libelle;
	}

	/**
	 * Setter libellé
	 * @param libelle libellé
	 */
	public void setLibelle(String libelle)
	{
		this.libelle = libelle;
	}

	/**
	 * Getter état valide
	 * @return Etat valide
	 */
	public int getEtatValide()
	{
		return etatValide;
	}

	/**
	 * Setter état valide
	 * @param etatValide Etat valide
	 */
	public void setEtatValide(int etatValide)
	{
		this.etatValide = etatValide;
	}

	public static NiveauDTO getNiveauDepuisCursor(Cursor cursor)
	{
		return new NiveauDTO(
				cursor.getString(cursor.getColumnIndex(BaseContrat.NiveauContrat.COLONNE_INTITULE)),
				cursor.getInt(cursor.getColumnIndex(BaseContrat.NiveauContrat.COLONNE_VALIDE))
		);
	}

}
