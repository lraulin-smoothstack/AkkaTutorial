package ch4;

import akka.actor.typed.ActorSystem;

public class Main {
    public static void main(String[] args) {
        ActorSystem<String> bigPrimes = ActorSystem.create(ManagerBehavior.create(),"ManagerActorSystem");
        bigPrimes.tell("start");
    }
}
