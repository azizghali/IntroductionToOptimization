import ilog.concert.IloException;
import ilog.concert.IloIntVar;
import ilog.concert.IloLinearIntExpr;
import ilog.concert.IloLinearNumExpr;
import ilog.concert.IloNumVar;
import ilog.cplex.IloCplex;


public class Optimization_11 {

	public Optimization_11() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {

		solveModel();
	}


	public static void solveModel() {

		try {

			IloCplex cplexOpt_11 = new IloCplex();

			//  ******* 1.  Defining variable *******
//			IloIntVar x = cplexOpt_11.intVar(0, Integer.MAX_VALUE, "x");
//			IloIntVar y = cplexOpt_11.intVar(0, Integer.MAX_VALUE, "y");
 
		 		IloNumVar x = cplexOpt_11.numVar(0, Double.MAX_VALUE, "x");
			 	 IloNumVar y = cplexOpt_11.numVar(0, Double.MAX_VALUE, "y");
			
			

			// ******* 2. Defining Expression  *******
		//	IloLinearIntExpr objective = cplexOpt_11.linearIntExpr();

		 	IloLinearNumExpr objective = cplexOpt_11.linearNumExpr();
			objective.addTerm(3, x);
			objective.addTerm(2, y);
			
			


			// ******* 3. defining Objective *******
			cplexOpt_11.addMaximize(objective);

			// ******* 4. Define Constraints *******
			cplexOpt_11.addLe(cplexOpt_11.sum(cplexOpt_11.prod(2, x), cplexOpt_11.prod(1, y)), 100.75);
			cplexOpt_11.addLe(cplexOpt_11.sum(cplexOpt_11.prod(1, x), cplexOpt_11.prod(1, y)), 80);
			cplexOpt_11.addLe(x, 40);
			cplexOpt_11.addGe(x, 0);
			cplexOpt_11.addGe(y, 0);

			// ******* 5. solve *******
			if(cplexOpt_11.solve()){
				System.out.println("Obje= " + cplexOpt_11.getObjValue());
				System.out.println("x= " + cplexOpt_11.getValue(x));
				System.out.println("y= " + cplexOpt_11.getValue(y));
			}
			else{
				System.out.println("Model Not solved");
			}

		} catch (IloException exc) {
			exc.printStackTrace();
		}

	}



}
