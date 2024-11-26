package lotto.view

import lotto.domain.Lotto
import lotto.domain.LottoRank
import lotto.domain.WinningStatistics

object ResultView {

    fun printPurchaseLotties(lotties: List<Lotto>) {
        lotties.forEach { println("${it.numbers}") }
        println()
    }

    fun printStatistics(statistics: WinningStatistics) {
        println(
            buildString {
                append("당첨통계\n")
                append("---------\n")
                statistics.statistics.filterKeys { it != LottoRank.NONE }.forEach { (rank, count) ->
                    append("${rank.matchCount}개 일치")
                    append(if (rank == LottoRank.SECOND) ", 보너스 볼 일치" else "")
                    append("(${rank.winningAmount}원)")
                    append(" - ")
                    append("${count}개\n")
                }
                append("총 수익률은 ${statistics.returnRate}입니다.\n")
            }
        )
    }

}
