import { useState } from "react";
import { Bar } from "recharts";
import { BarChart, XAxis, YAxis, Tooltip, CartesianGrid, Legend, ResponsiveContainer } from "recharts";
import { Table } from "@/components/ui/table";
import { Button } from "@/components/ui/button";
import { BarChart3, List } from "lucide-react";

const fxData = {
  title: "FX Open Position",
  data: [
    { currency: "GBP", amount: 58000, usd_equivalent: 56000 },
    { currency: "EUR", amount: 12000, usd_equivalent: 12000 },
    { currency: "JPY", amount: 25000, usd_equivalent: 25000 },
    { currency: "Others", amount: 35000, usd_equivalent: 35000 }
  ],
  unit: "USD"
};

export default function FXOpenPosition() {
  const [view, setView] = useState("chart");

  return (
    <div className="p-4 max-w-2xl mx-auto bg-white rounded-2xl shadow-lg">
      <div className="flex justify-between items-center mb-4">
        <h2 className="text-xl font-bold">{fxData.title}</h2>
        <div className="space-x-2">
          <Button onClick={() => setView("chart")} variant={view === "chart" ? "default" : "outline"}>
            <BarChart3 className="w-5 h-5" />
          </Button>
          <Button onClick={() => setView("table")} variant={view === "table" ? "default" : "outline"}>
            <List className="w-5 h-5" />
          </Button>
        </div>
      </div>
      {view === "chart" ? (
        <ResponsiveContainer width="100%" height={300}>
          <BarChart data={fxData.data}>
            <CartesianGrid strokeDasharray="3 3" />
            <XAxis dataKey="currency" />
            <YAxis />
            <Tooltip />
            <Legend />
            <Bar dataKey="usd_equivalent" fill="#3182CE" />
          </BarChart>
        </ResponsiveContainer>
      ) : (
        <Table>
          <thead>
            <tr>
              <th>Currency</th>
              <th>Amount</th>
              <th>USD Equivalent</th>
            </tr>
          </thead>
          <tbody>
            {fxData.data.map((item) => (
              <tr key={item.currency}>
                <td>{item.currency}</td>
                <td>{item.amount.toLocaleString()}</td>
                <td>{item.usd_equivalent.toLocaleString()}</td>
              </tr>
            ))}
          </tbody>
        </Table>
      )}
    </div>
  );
}
