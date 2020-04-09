package ch4;

import akka.actor.typed.ActorSystem;

public class Main {
    public static void main(String[] args) {
        ActorSystem<ManagerBehavior.Command> bigPrimes = ActorSystem.create(ManagerBehavior.create(),"ManagerActorSystem");
        bigPrimes.tell(new ManagerBehavior.InstructionCommand("start"));
    }
}
