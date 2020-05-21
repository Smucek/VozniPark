package VozniPark

import java.text.SimpleDateFormat
import java.util.Calendar

class Vozilo (marka: String, model: String, kategorija: String, godinaProizvodnje: String,
              datumReg: String, datumIstekaReg: String) {

  def markaVozila(): String = marka
  def modelVozila(): String = model
  def kategorijaVozila(): String = kategorija
  def godinaProizvodnjeVozila(): String = godinaProizvodnje
  def datumRegVozila(): String = datumReg
  def datumIstekaRegVozila(): String = datumIstekaReg

  def istekRegistracije: Boolean = {

    val uneseniDatumIstekaReg = datumIstekaRegVozila
    val uneseniDatum = new SimpleDateFormat("dd.MM.yyyy").parse(uneseniDatumIstekaReg)

    val trenutniDatumPlusMjesec = Calendar.getInstance()
    trenutniDatumPlusMjesec.add(Calendar.MONTH, 1)
    val provjera = trenutniDatumPlusMjesec.getTime

    val isticeZaMjesec: Boolean = uneseniDatum.before(provjera)

    isticeZaMjesec
  }
}

//object Vozilo {
//  def ucitajIzFajla(red: String): Vozilo = {
//
//    val dijelovi: Seq[String] = red.split("\t")
//
//    new Vozilo (dijelovi(0), dijelovi(1), dijelovi(2), dijelovi(3), dijelovi(4), dijelovi(5))
//  }
//}
