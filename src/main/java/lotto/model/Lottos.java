package lotto.model;

import java.util.List;

public class Lottos {

    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public int countOfRank(Rank rank, WinningLotto winningLotto) {
        return (int) lottos.stream().filter(lotto -> rank.matches(winningLotto, lotto)).count();
    }
}