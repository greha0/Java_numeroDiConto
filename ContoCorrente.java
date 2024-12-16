
    /**
     Un conto bancario ha un saldo che può essere modificato da depositi e prelievi
     */
    public class ContoCorrente {
        private double saldo;
        static private int contConto;
        private int numeroConto;
        /**
         Costruisce un conto bancario con saldo uguale a zero
         */
        public ContoCorrente() {
            saldo = 0;
            numeroConto = contConto;
            contConto++;
        }
        /**
         Costruisce un conto bancario con un saldo assegnato
         @param saldoIniziale il saldo iniziale
         */
        public ContoCorrente(double saldoIniziale) {
            saldo = saldoIniziale;
            numeroConto = contConto;
            contConto++;
        }
        /**
         Versa denaro nel conto bancario
         Se l'importo è inferiore al saldo non
         viene eseguita l'operazione
         @param importo l'importo da versare
         */
        public void deposita(double importo) {
            if(importo < 0)
                throw new IllegalArgumentException("Importo non può essere negativo");
            double nuovoSaldo = saldo + importo;
            saldo = nuovoSaldo;
        }
        /**
         Preleva denaro dal conto bancario
         Se l'importo è inferiore al saldo non
         viene eseguita l'operazione
         @param importo l'importo da prelevare
         */
        public void preleva(double importo) {
            assert importo < getSaldo(); //messaggio standard

            double nuovoSaldo = saldo - importo;
            saldo = nuovoSaldo;
        }
        /**
         Ispeziona il valore del saldo attuale del conto bancario
         @return il saldo attuale
         */
        public double getSaldo() {
            return saldo;
        }

        /**
         * Trasferisce un importo ad un altro conto.
         * @param importo importo da trasferire
         * @param conto conto corrente su cui inviare i soldi
         */
        public void bonifico(double importo, ContoCorrente conto){
            this.preleva(importo);
            conto.deposita(importo);
        }

        /**
         * Ispeziona il valore del numero del conto
         * @return il numero del conto
         */
        public int getNumeroConto(){
            return numeroConto;
        }

        public static void main(String [] args){
            ContoCorrente c1 = new ContoCorrente();
            ContoCorrente c2 = new ContoCorrente();

            System.out.println("c1: " + c1.getNumeroConto());
            System.out.println("c2: " + c2.getNumeroConto());
        }
    }

